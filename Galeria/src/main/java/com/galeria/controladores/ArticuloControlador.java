package com.galeria.controladores;

import java.util.Base64;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.galeria.GaleriaApplication;
import com.galeria.entidades.Articulo;
import com.galeria.entidades.Transaccion;
import com.galeria.servicios.IArticuloServicio;
import com.galeria.servicios.IArtistaServicio;


@Controller()
@RequestMapping(value = "/articulo")

public class ArticuloControlador {

	private static Logger LOG = LoggerFactory.getLogger(GaleriaApplication.class);

	@Autowired
	private IArticuloServicio servicioArticulo;

	@Autowired
	private IArtistaServicio servicioArtista;

	@GetMapping(value = "/list")
	public String list(Model model) {

	//	model.addAttribute("articulos", this.servicioArticulo.getAll());

		return "articulo/articuloDataTable";
	}

	@GetMapping(value = "/add")
	public String add(Model model) {

		model.addAttribute("editar", false);

		model.addAttribute("articulo", new Articulo());

		model.addAttribute("artistas", this.servicioArtista.getAll());

		return "articulo/articulo";
	}

	@PostMapping(value = "/add")
	public String add(@Valid Articulo articulo, BindingResult result, Model model, MultipartFile file)
			throws Exception {

		LOG.info("Guardando Articulo");

		if (result.hasErrors()) {

			model.addAttribute("artistas", this.servicioArtista.getAll());

			return "articulo/articulo";
		}

		articulo.setFoto64(Base64.getEncoder().encodeToString(file.getBytes()));

		this.servicioArticulo.add(articulo);

		return "redirect:/articulo/list";

	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id) throws Exception {

		this.servicioArticulo.delete(id);

		return "redirect:/articulo/list";
	}

	@GetMapping(value = "/editar/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {

		Articulo articulo = this.servicioArticulo.getById(id);

		model.addAttribute("editar", true);
		model.addAttribute("artistas", this.servicioArtista.getAll());
		model.addAttribute("articulo", articulo);

		return "articulo/articulo";
	}

	@PostMapping(value = "/editar/{id}")
	public String editar(@Valid Articulo articulo, BindingResult result, RedirectAttributes redirectAttributes,
			MultipartFile file) throws Exception {

		if (result.hasErrors()) {
			return "articulo/articulo";
		}

		LOG.info("El fichero esta vacio" + file.isEmpty());
		LOG.info("El nombre del fichero es:" + file.getName());
		LOG.info("El contenido del fichero es:" + file.getContentType());

		if (!file.isEmpty()) {
			articulo.setFoto64(Base64.getEncoder().encodeToString(file.getBytes()));
		}

		this.servicioArticulo.update(articulo);

		redirectAttributes.addFlashAttribute("mensaje", "Modificado correctamente").addFlashAttribute("clase",
				"success");

		return "redirect:/articulo/list";
	}

	@GetMapping(value = "/{id}/detalle")
	public String getDetalles(@PathVariable(value= "id" ) Long id, Model model) throws Exception {
		
		Transaccion transaccion = new Transaccion();
		
		transaccion.setArticulo(this.servicioArticulo.getById(id));
		
		model.addAttribute("articulo", this.servicioArticulo.getById(id));
		model.addAttribute("transaccion", transaccion);
		
		return "articulo/articuloDetalle";
	}
	
	@GetMapping(value = "/{id}/transaccion/list")
	public String listarTransccion(@PathVariable(value = "id") Long id, Model model) throws Exception {

		model.addAttribute("transaccion", this.servicioArticulo.getById(id).getTransacciones());

		return "transaccion/transaccionList";
	}


}
