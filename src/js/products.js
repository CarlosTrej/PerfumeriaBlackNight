
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
        sessionStorage.removeItem('sesion')
        location.href = "./../index.html";
      }
    })/* fire */

    function closeSesion(e){
        const aEvent = e.target;
        alertmodal()
    }/* closeSesion */
}/* alertmodal */





const API = "http://127.0.0.1:8085/api/v1/productos/";
const productosPromise = fetch(API);
let itemsProducts= document.getElementById("list-products");

productosPromise
.then(function(data)
{ 
    return data.json(); 

})
.then(function(data)
{
    addItem(data)

})
.catch(function(error)
{
    console.log(error);

})/* productosPromise */


function addItem(products){
        products.forEach(function(item){
          let other = format(item.costo)
          itemsProducts.innerHTML +=`
          <br><div class="col-12 col-sm-12 col-md-6 col-lg-4 col-xl-4" >
                <div class="card " style="height: 650px;">
                  <img src="${item.img}" class="card-img-top" height= "50%" alt="...">
                   <div class="card-body" margin-bottom= "15px">
                      <center><h5 class="card-title" style="font-weight: 600;">${item.nombre}</h5>
                      <p class="card-text">Presentación</p>
                      <p class="card-text">${item.cantidad} ml</p>
                      <p class="card-text">$${other} MXN</p> </center><br>
                      <center><a type="button" onclick="redirect(${item.id_perfume})" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#qwerty" style="background-color: #0E8784;">Ver más</a></center>
                    </div>
                </div><br>
              </div>
          <br>
          `
          let element = {
            id:item.id_perfume,
            name:item.nombre,
            img: item.img,
            size: item.cantidad,
            precio: item.costo,
          }
          localStorage.setItem(item.id_perfume, JSON.stringify(element));
        })
        
}//function

function redirect(x){
    setTimeout(function(){
        location.href = `./details.html?id=${x}`;
    },1000);

}/* redirect */
        
function format(num){
        if(num < 1000){
          return num;
        }else if(!isNaN(num)){
        num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1,');
        num = num.split('').reverse().join('').replace(/^[\.]/,'');
        return num;
        }
}/* format */  
      
function alertDescription(description){
    Swal.fire({
      title: '<strong>Descripción</strong>',
      icon: 'info',
      html:
        `${description.value}`,
      showCloseButton: true,
      showCancelButton: true,
      focusConfirm: false,
      confirmButtonText:
        '<i class="fa fa-thumbs-up"></i> Great!',
      confirmButtonAriaLabel: 'Thumbs up, great!',
    })
}/* alertDescription */
