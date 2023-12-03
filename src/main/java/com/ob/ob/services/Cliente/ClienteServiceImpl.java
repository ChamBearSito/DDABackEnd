package com.ob.ob.services.Cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ob.ob.entity.Cliente;
import com.ob.ob.entity.Regular;
import com.ob.ob.entity.VIP;
import com.ob.ob.repository.ClienteRepository;
import com.ob.ob.repository.RegularRepository;
import com.ob.ob.repository.VIPRepository;
import com.ob.ob.utils.AppException;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository cliRepo;
    @Autowired
    private VIPRepository vipRepo;
    @Autowired
    private RegularRepository regularRepo;

    // region REGULAR
    @Override
    @Transactional
    public List<Regular> getAllRegular() {
        return regularRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<Regular> getAregular(int id) {
        return regularRepo.findById(id);
    }

    @Override
    @Transactional
    public Regular save(Regular cli) throws AppException {
        try {

            return regularRepo.save(cli);
        } catch (Exception e) {
            throw new AppException("Error Guardar Cliente Regular");
        }

    }

    @Override
    @Transactional
    public Regular update(Regular cli) throws AppException {
        try {
            if (cliRepo.existsById(cli.getId())) {
                return regularRepo.save(cli);
            } else {
                // Manejar el caso en el que la persona no existe
                throw new AppException("La persona a modificar no existe");
            }

        } catch (Exception e) {
            throw new AppException("Error al Actualizar la persona");
        }

    }
    // endregion

    // region VIP
    @Override
    @Transactional
    public List<VIP> getAllVIP() {
        return vipRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<VIP> getAvip(int id) {
        return vipRepo.findById(id);
    }

    @Override
    @Transactional
    public VIP saveVIP(VIP cli) throws AppException {
        try {
            return vipRepo.save(cli);

        } catch (Exception e) {
            throw new AppException("Error Guardar Cliente Regular");
        }
    }

    @Override
    @Transactional
    public VIP updateVIP(VIP cli) throws AppException {

        try {

            if (cliRepo.existsById(cli.getId())) {

                return vipRepo.save(cli);
            } else
                throw new AppException("CLIENTE VIP NO EXISTE");
        } catch (Exception e) {
            throw new AppException("Error al Actualizar Cliente VIP");
        }

    }
    // endregion

    // region GLOBAL
    // @Override
    // @Transactional
    // public String delete(int id){
    // cliRepo.deleteById(id);
    // return "Se ha eliminado correctamente";
    // }

    public boolean existUserenVenta(@PathVariable int userId) {
        return cliRepo.existsByClienteId(userId);
    }

    @Override
    @Transactional
    public ResponseEntity<String> delete(int id) throws AppException {
        try {

            if (existUserenVenta(id)) {
                return new ResponseEntity<>("Existen datos en ventas de este producto, no es posible eliminar",
                        HttpStatus.METHOD_NOT_ALLOWED);
            } else {
                cliRepo.deleteById(id);
                return new ResponseEntity<>("Se ha eliminado correctamente", HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new AppException("Error al Encontrar al eliminar al Cliente ");
        }
    }

    @Override
    @Transactional
    public List<Cliente> getAll() {
        return cliRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<Cliente> getAclient(int id) throws AppException {
        try {

            return cliRepo.findById(id);
        } catch (Exception e) {
            throw new AppException("Error al Encontrar al Cliente ");
        }
    }
    // endregion
}
