
function searchSesion(){
    let sesion = sessionStorage.getItem('sesion');
    return sesion;
  }
  
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
  
let Total = document.querySelector("#total-value span");
let tbody = document.querySelector(".tbody")

window.onload = function(){
    const idsesion = searchSesion();
    initSesion(idsesion);
    carValid()
    if(serachURL() == null){
        addItemCar()
    }else{
        location.href="./carritoCompras.html"
    }/* else */
}/* window.onload */

function serachURL(){
    let URL = location.search;
    let params = new URLSearchParams(URL);
    let idParam = params.get("id");
    return idParam;
}/* serachUR */

function carValid(){
    let carStay = JSON.parse(localStorage.getItem("carrito"));
    if(carStay == null){
        let carrito = [];
        localStorage.setItem("carrito", JSON.stringify(carrito));
        console.log("no habia carrito y se creo")
        addCar()
    }else{
        addCar()
    }/* else */
}/* carValid */

function addCar(){

    const idProducto = serachURL();
    if(idProducto == null){
        addItemCar
    }else{
        let iD= JSON.parse(localStorage.getItem(idProducto));
        let element={
            id:iD.id,
            name:iD.name,
            img: iD.img,
            size: iD.size,
            costo: parseInt(iD.precio,10),
            cantidad: 1
        }
        let flag=false;
        let newItem = [];
        newItem = JSON.parse(localStorage.getItem("carrito"));
        newItem.forEach(elemento=>{
            if(element.id === elemento.id){
                elemento.cantidad+=element.cantidad
                localStorage.setItem("carrito", JSON.stringify(newItem));
                flag=true; 
            }
        })
        if(!flag){    
            newItem.push(element);
            localStorage.setItem("carrito", JSON.stringify(newItem)); 
        }
        addItemCar()
    }/* else */    
}/* addCar */

function addItemCar(){
    let newItem = [];
    newItem = JSON.parse(localStorage.getItem("carrito"));
    newItem.forEach(function(item){
        tbody.innerHTML += `
        <tr class="product" >
            <td class="name">
                <span>${item.name}</span>
            </td>
            <td class="pu">
                $<span>${item.costo}</span>
            </td>
            <td class="qty">
                <span>${item.cantidad}</span>
            </td>
            <td class="subtot">
                $<span>0</span>
            </td>
            <td class="rm">
                <button class="btn btn-dark" id="delete" type="button"><b>Borrar</b></button>
            </td>
        </tr>
        `
        calculaTodoTotal();
        tbody.querySelectorAll("#delete").forEach(item =>{
            item.addEventListener('click', removeitem); 
        })/* forEach.addEventListener */   
    }); /* newItem.forEach */

}/* addItemCar */


function updateSub(producto){
    const priceUnit = producto.querySelector(".pu span").textContent;
    const quantify = producto.querySelector(".qty span").textContent;
    const total = (parseFloat(priceUnit))*(parseFloat(quantify));
    const subtotal = producto.querySelector(".subtot span");
    subtotal.innerHTML= parseFloat(total);
    return total
}/* updateSub */


function calculaTodoTotal(){
    const productos = document.getElementsByClassName("product");
    let totaldeTotales = 0;
    for (let i = 0; i < productos.length ; i++){
        totaldeTotales += updateSub(productos[i]); 
    }/* for */
    Total.innerHTML = format(totaldeTotales)+" MXN";   
}/* calculaTodoTotal */


function format(num){

    if(num < 1000){
      return num;
    }else if(!isNaN(num)){
    num = num.toString().split('').reverse().join('').replace(/(?=\d*\.?)(\d{3})/g,'$1,');
    num = num.split('').reverse().join('').replace(/^[\.]/,'');
    return num;
    }
  }/* format */


function removeitem(e){
    e.preventDefault();
    const buttonClicked = e.target;
    
    let newItem = [];
    newItem = JSON.parse(localStorage.getItem("carrito"));
    let flag = true;
    newItem.forEach(elemento=>{

        if(elemento.cantidad > 1){
            elemento.cantidad-=1;
            calculaTodoTotal();
            localStorage.setItem("carrito", JSON.stringify(newItem));
            flag =false;   
            tbody.innerHTML="";
        }
    })/* forEach */

    if(flag == false){
        let newItem = [];
        newItem = JSON.parse(localStorage.getItem("carrito"));
        newItem.forEach(function(item){
            tbody.innerHTML += `
            <tr class="product" >
                <td class="name">
                    <span>${item.name}</span>
                </td>
                <td class="pu">
                    $<span>${item.costo}</span>
                </td>
                <td class="qty">
                    <span>${item.cantidad}</span>
                </td>
                <td class="subtot">
                    $<span>0</span>
                </td>
                <td class="rm">
                    <button class="btn btn-dark" id="delete" type="button"><b>Borrar</b></button>
                </td>
            </tr>
            `
            calculaTodoTotal();
            
            tbody.querySelectorAll("#delete").forEach(item =>{
                item.addEventListener('click', removeitem); 
            })/* forEach.addEventListener */   
        }); /* newItem.forEach */
    }/* ifFlagFalse */

    if(flag){
        newItem.shift();
        localStorage.setItem("carrito", JSON.stringify(newItem));
        buttonClicked.closest(".product").remove(); 
    }/* ifFlagTrue */

    calculaTodoTotal();
}/* removeitem */





