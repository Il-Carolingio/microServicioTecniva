package com.ms_tecniva.microservicio.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_tecniva.microservicio.model.usuario_mdl;
import com.ms_tecniva.microservicio.repository.usuario_rep;

@RestController
@RequestMapping("/usuarios")
public class usuario_ctr {
    private usuario_rep usuarioRepository;

    @Autowired
    public usuario_ctr(usuario_rep usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<usuario_mdl> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public usuario_mdl crearUsuario(@RequestBody usuario_mdl usuario) {
        return usuarioRepository.save(usuario);
    }

    @PostMapping
    public usuario_mdl actualizarUsuario(@RequestBody usuario_mdl usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        Optional<usuario_mdl> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioRepository.delete(usuarioOptional.get());
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Otros métodos de API REST
}