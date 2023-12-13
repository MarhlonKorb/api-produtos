package com.api.produtos.login;

import com.api.produtos.usuario.Usuario;
import com.api.produtos.usuario.UsuarioRepository;
import com.api.produtos.usuario.dto.UsuarioDto;
import com.api.produtos.usuario.dto.UsuarioLogin;
import com.api.produtos.validador.senha.ISenhaValidador;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ISenhaValidador senhaValidador;

    /**
     * Método responsável por realizar a busca e validação pelo email
     *
     * @param usuarioInput
     * @return UsuarioDto
     * @throws EntityNotFoundException
     */
    @Override
    public UsuarioDto login(UsuarioLogin usuarioInput) throws EntityNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioInput.email());
        senhaValidador.validar(usuarioInput.senha(), usuario.get().getSenha());
        return new UsuarioDto(usuario.get().getEmail(), usuario.get().getNome());
    }

}
