package com.ob.ob.services.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.ob.ob.entity.Cliente;
import com.ob.ob.entity.Regular;
import com.ob.ob.entity.VIP;
import com.ob.ob.utils.AppException;

public interface ClienteService {
    public Regular save(Regular user) throws AppException;

    public VIP saveVIP(VIP user) throws AppException;

    public List<Cliente> getAll();

    public List<VIP> getAllVIP();

    public List<Regular> getAllRegular();

    public Optional<Cliente> getAclient(int id) throws AppException;

    public Optional<Regular> getAregular(int id);

    public Optional<VIP> getAvip(int id);

    public ResponseEntity<String> delete(int id) throws AppException;

    public Regular update(Regular user) throws AppException;

    public VIP updateVIP(VIP user) throws AppException;
}