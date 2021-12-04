
package Reto1_Ciclo4.Reto1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yeison Orozco
 * @version 1.1
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController{
   
    /**
    * Creacion del Objeto UserService
    */
   @Autowired
   private UserService userService;
   
   /**
    * Metodo Get para la Captura de la base de datos en List<User>
    *@param none
    *@return userService.getAll
    */
   @GetMapping("/all")
   public List<User> getAll(){
       return userService.getAll();
   }
   
   /**
    * Metodo Post EndPoint api/new para la creacion de nuevos usuarios
    * @param user
    * @return registrar
    */
   @PostMapping("/new")
   @ResponseStatus(HttpStatus.CREATED)
   public User registrar(@RequestBody User user){
       return userService.registrar(user);
   }
   
   /**
    * Metodo Get EndPoint api/{email}/{password} para la autenticacion de los usuarios existentes
    * @param email & password
    * @return autenticarUsuario
    */
   @GetMapping("/{email}/{password}")
   public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password){
       return userService.autenticarUsuario(email, password);
   }
   
   /**
    * Metodo Get EndPoint api/{email} para validar la existencia de un usuario a traves de su email
    * @param email
    * @return existeEmail
    */
   @GetMapping("/{email}")
   public boolean existeEmail(@PathVariable("email") String email){
       return userService.existeEmail(email);
   }
}
