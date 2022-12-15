
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
  