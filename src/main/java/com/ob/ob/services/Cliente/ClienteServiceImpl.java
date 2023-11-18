package com.ob.ob.services.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.ob.entity.Cliente;
import com.ob.ob.entity.Regular;
import com.ob.ob.entity.VIP;
import com.ob.ob.repository.ClienteRepository;
import com.ob.ob.repository.RegularRepository;
import com.ob.ob.repository.VIPRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository cliRepo;
    @Autowired
    private VIPRepository vipRepo;
    @Autowired
    private RegularRepository regularRepo;

    //region REGULAR
    @Override
    @Transactional
    public List<Regular> getAllRegular(){
        return regularRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<Regular> getAregular(int id){
        return regularRepo.findById(id);
    }

    @Override
    @Transactional
    public Regular save(Regular cli){
        return regularRepo.save(cli);
    }

    @Override
    @Transactional
    public Regular update(Regular cli){
        return regularRepo.save(cli);
    }
    //endregion

    //region VIP
    @Override
    @Transactional
    public List<VIP> getAllVIP(){
        return vipRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<VIP> getAvip(int id){
        return vipRepo.findById(id);
    }

    @Override
    @Transactional
    public VIP saveVIP(VIP cli){
        return vipRepo.save(cli);
    }

    @Override
    @Transactional
    public VIP updateVIP(VIP cli){
        return vipRepo.save(cli);
    }
    //endregion

    //region GLOBAL
    @Override
    @Transactional
    public String delete(int id){
        cliRepo.deleteById(id);
        return "Se ha eliminado correctamente";
    }

    @Override
    @Transactional
    public List<Cliente> getAll(){
        return cliRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<Cliente> getAclient(int id){
        return cliRepo.findById(id);
    }
    //endregion
}
