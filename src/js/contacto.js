
function searchSesion(){
  let sesion = sessionStorage.getItem('sesion');
  return sesion;
}

window.onload = function(){
  const idsesion = searchSesion();
  initSesion(idsesion);
}/* window.onload */


function initSesion(idsesion){
  let iconSesion = document.getElementById("sesiontools");
  if(searchSesion() != null){
     
      iconSesion.innerHTML=`
      <a class="navbar-brand" href="./../index.html">
      <img src="../src/images/_perfumeria.jpeg" width="50" height="50" class="d-inline-block align-top" alt="">
      The Black Nigth</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="./../index.html">Inicio <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="contacto_form.html">Contacto</a>
      </li>
      <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Productos
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="products.html">Perfumes</a>
          </div>
        </li>
        <li class="nav-item active dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Nosotros
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="theblack.html">The Black Nigth</a>
          <a class="dropdown-item" href="acercaDeNosotros.html">Ubicación</a>
          </div>
        </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" id="formBlack" style="color: black;">
      
      <ul class="nav-item active dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size:xlarge; color: black;">
            Bienvenido
           </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="nav-link" type="submit" id="navbarScrollingDropdow" href="addcard.html?usuarioactivo=${idsesion}" style="font-size:large; color: black;">
             Agregar Producto
            </a>
            <a style=" font-size: 1.2em; cursor: pointer; color:black;" class="nav-link" type="click" id="cerrarsesion" style="font-size:large; color: black;">
            Cerrar Sesión
           </a>
          </div>
      </ul>
        <ul class="nav-item active">
          <a class="nav-link"href="carritoCompras.html" ><i id="icono" class="bi bi-cart4"></i></a>
        </ul>
    </form>
  </div>
  `;
  let button = iconSesion.querySelector("#cerrarsesion");
  if(button.getAttribute('listener') !=='true' ){
      button.addEventListener('click', function(e){
          alertmodall()
      })   

  }
}
}/* initSesion */

function alertmodall(){

  Swal.fire({
      title: '¿Quieres cerrar tu sesión?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#0E8784',
      cancelButtonColor: 'black',
      confirmButtonText: 'Cerrar sesión',
      cancelButtonText: 'Cancelar' 
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'Haz cerrado sesión'
        )
        setTimeout(()=>{
          sessionStorage.removeItem('sesion')
          location.href = "./../index.html";
        },1000);
      }
    })/* fire */

    function closeSesion(e){
        const aEvent = e.target;
        alertmodal()
    }/* closeSesion */
}/* alertmodal */



let form = document.getElementById("contact-form");



form.addEventListener("submit",function(e){

    e.preventDefault();
    let nme = document.getElementById("name");
    let email = document.getElementById("email");
    let phone = document.getElementById("phone");
    let message = document.getElementById("message");
    /* parseamos el dato phone a number */
    let phone_number=parseInt(phone.value,10);
    
    /* validacion del campo nombre */
    if(nme.value.length == 0){
        /* para validar que no este vacío el campo nombre */
        alertModal("El campo nombre no puede quedar vacío");

    }else{

        /* validación del campo email */
        if(email.value.length <= 8 ){
            /* Para validar si el email es corto */
            email.classList.add("is-invalid");
            alertModal("Tu correo necesíta al menos 8 carácteres para ser válido");
            email.value = "";

        }else if(email.value.length >=40){
            /* Para validar si el email es demasiado largo*/
            email.classList.add("is-invalid");
            alertModal("Tu correo excede el máximo de  40 carácteres para ser válido");
            email.value = "";

        }else if(email.value.length == 0){
             /* para validar que no este vacío el campo email */
            alertModal("El campo correo electrónico no puede quedar vacío");
        
        }else{

            /* validaciones del campo telefono */
            if(phone.value.length<10 || phone_number <= 0 || phone.value.length >=11){
                /* Validar los 10 digitos del valor del campo teléfono */
                phone.classList.add("is-invalid");
                alertModal("Número de teléfono erróneo, verifica tu número");
                phone.value = "";

            }else if(isNaN(phone.value)){
                /* validar que no ingresen letras en el campo teléfono */
                phone.classList.add("is-invalid");
                alertModal("No ingresar palabras en el campo de teléfono");

            /* Validaciones del campo message */
            }else{
                    
                    if(message.value.length == 0 || message.value.length <20){
                        /* Validar el mínimo de caracteres del campo message */
                        alertModal("El campo texto necesita al menos 20 caracteres");
                    }else{
                        /* función para mandar el email */
                        sendEmail(nme,email,message,phone);
                    }/* sendEmail */

                }/* phone.values */

            }/* email.values */

        }/* nme.values */
        

});/* form.addEventListener */
    


function sendEmail(nme,email,message,phone){
    Email.send({
        Host : "smtp.elasticemail.com",
        Username : "carlostrejo182@gmail.com",
        Password : "CEE868D15EBDAA1830EFDE0D2589DEB74A8B",
        To : "carlostrejo182@gmail.com",
        From :  "carlostrejo182@gmail.com",
        Subject : "Perfumeria Email",
        Body : `Hola soy ${nme.value} mi correo es ${email.value} ${message.value} mi telefono es ${phone.value}`
    }).then(
        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Tus datos han sido enviados satisfactoriamente.',
            showConfirmButton: false,
            timer: 1500
          })
          
    );
    clearInputs(nme,email,message,phone);

}/* function sendEmail */

function alertModal(text){
    Swal.fire({
        title: 'Alerta',
        text: `¡${text}!`,
        icon: 'warning',
        cancelButtonColor: '#d33',
        cancelButtonText: "Okay"
        
      })
}/* function alertModal */

function clearInputs(nme,email,message,phone){
    nme.value = "";
    email.value = "";
    message.value = "";
    phone.value = "";
    email.classList.remove("is-invalid");
    phone.classList.remove("is-invalid");
}/* function clearInputs */