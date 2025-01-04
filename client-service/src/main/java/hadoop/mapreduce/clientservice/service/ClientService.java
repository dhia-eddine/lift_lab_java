package hadoop.mapreduce.clientservice.service;


import hadoop.mapreduce.clientservice.dto.CreateClientDto;
import hadoop.mapreduce.clientservice.dto.UpdateClientDto;
import hadoop.mapreduce.clientservice.entity.Client;
import hadoop.mapreduce.clientservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Client createClient(CreateClientDto createClientDto) {
        Client client = new Client();
        client.setName(createClientDto.getName());
        client.setEmail(createClientDto.getEmail());
        client.setMobile(createClientDto.getMobile());
        client.setAddress(createClientDto.getAddress());
        return clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client updateClient(Long id, UpdateClientDto updateClientDto) {
        Client client = getClientById(id);
        client.setName(updateClientDto.getName());
        client.setEmail(updateClientDto.getEmail());
        client.setMobile(updateClientDto.getMobile());
        client.setAddress(updateClientDto.getAddress());
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }
}