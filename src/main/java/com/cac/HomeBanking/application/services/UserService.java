package com.cac.HomeBanking.application.services;

import com.cac.HomeBanking.api.dtos.AccountDto;
import com.cac.HomeBanking.api.dtos.UserDto;
import com.cac.HomeBanking.api.mappers.AccountMapper;
import com.cac.HomeBanking.api.mappers.UserMapper;
import com.cac.HomeBanking.domain.exceptions.AccountNotFoundException;
import com.cac.HomeBanking.domain.models.Account;
import com.cac.HomeBanking.domain.models.User;
import com.cac.HomeBanking.domain.repositories.AccountRepository;
import com.cac.HomeBanking.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    public UserService(UserRepository repository, AccountRepository accountRepository) {
        this.repository = repository;
        this.accountRepository = accountRepository;

    }

    public List<UserDto> getUsers() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(UserMapper::userMapToDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        return UserMapper.userMapToDto(repository.findById(id).get());
    }

    public UserDto createUser(UserDto user) {
        return UserMapper.userMapToDto(repository.save(UserMapper.dtoToUser(user)));
    }

    public UserDto update(Long id, UserDto user) {

        Optional<User> userCreated = repository.findById(id);

        if (userCreated.isPresent()) {
            User entity = userCreated.get();

            User accountUpdated = UserMapper.dtoToUser(user);
            accountUpdated.setAccounts(entity.getAccounts());

            if (user.getIdAccounts() != null) {
                List<Account> accountList = accountRepository.findAllById(user.getIdAccounts());
                List<Account> accountListFilter = accountList.stream().filter(e -> !entity.getAccounts().contains(e)).collect(Collectors.toList());;
                accountUpdated.getAccounts().addAll(accountListFilter);
                accountUpdated.setAccounts(accountList);
            }
            accountUpdated.setId(entity.getId());

            User saved = repository.save(accountUpdated);

            return UserMapper.userMapToDto(saved);
        } else {
            throw new AccountNotFoundException("User not found with id: " + id);
        }
    }

    public String delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Se ha eliminado la cuenta";
        } else {
            return "No se ha eliminado la cuenta";
        }
    }

    public UserDto addAccountToUser(Long id, AccountDto account) {
        // Primero: buscar el usuario por id
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Segundo: crear la cuenta y asociarla al usuario
            Account newAccount = AccountMapper.dtoToAccount(account);
            newAccount.setOwner(user);
            Account savedAccount = accountRepository.save(newAccount);

            // Tercero: agregar la cuenta a la lista del usuario
            user.getAccounts().add(savedAccount);

            // Guardar los cambios en el usuario
            User savedUser = repository.save(user);

            // Devolver el usuario con la cuenta agregada
            return UserMapper.userMapToDto(savedUser);
        } else {
            throw new AccountNotFoundException("User not found with id: " + id);
        }
    }
}
