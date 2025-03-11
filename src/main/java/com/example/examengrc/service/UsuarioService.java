package com.example.examengrc.service;

import com.example.examengrc.model.Usuario;
import com.example.examengrc.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario usuarioToUpdate = usuarioRepository.findById(id).orElse(null);
        if (usuarioToUpdate == null) {
            return null;
        }
        usuarioToUpdate.setNombre(usuario.getNombre());
        usuarioToUpdate.setEmail(usuario.getEmail());
        usuarioToUpdate.setLicenseNumber(usuario.getLicenseNumber());
        usuarioToUpdate.setGrc_password(usuario.getGrc_password());
        usuarioToUpdate.setGrc_address(usuario.getGrc_address());
        return usuarioToUpdate;
    }
}
