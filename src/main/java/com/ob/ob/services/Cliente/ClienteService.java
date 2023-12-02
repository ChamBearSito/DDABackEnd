package com.ob.ob.services.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.ob.ob.entity.Cliente;
import com.ob.ob.entity.Regular;
import com.ob.ob.entity.VIP;

public interface ClienteService {
    public Regular save(Regular user);

    public VIP saveVIP(VIP user);

    public List<Cliente> getAll();

    public List<VIP> getAllVIP();

    public List<Regular> getAllRegular();

    public Optional<Cliente> getAclient(int id);

    public Optional<Regular> getAregular(int id);

    public Optional<VIP> getAvip(int id);

    public ResponseEntity<String> delete(int id);

    public Regular update(Regular user);

    public VIP updateVIP(VIP user);
}