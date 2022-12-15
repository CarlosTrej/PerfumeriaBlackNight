/* para añadir elementos al JSON */
function saveShirt(e){
    e.preventDefault();
  
   let nombre= document.getElementById("nombre").value,
       descripcion= document.getElementById("descripcion").value,
       precio= document.getElementById("precio").value,
       image= document.getElementById("imagen").value;
   console.log(nombre);
   console.log(descripcion);
   console.log(precio);
   console.log(image);

   let newShirt={
       model:nombre,
       price: precio,
       description: descripcion,
       img: image
   };//new shirt

   let valueInLocalStorage=  window.localStorage.getItem("localShirt");
   let storeList;
   if(valueInLocalStorage){
       // 1. Traer lo que tengas en el localStorage
       // 2. Convertirlo de json a un arreglo
       // 3. hacer push del nuevo objeto
       // 4. Volver a arreglo a json
       // 5. Actualizar el item  
       storeList= JSON.parse(valueInLocalStorage)
       storeList.push(newShirt);
       console.log(storeList)
       window.localStorage.setItem("localShirt",JSON.stringify(storeList));
       nombre= '';
       descripcion= '';

   }else{
       window.localStorage.setItem("localShirt",JSON.stringify(ShirtBase));
       valueInLocalStorage= ShirtBase
   }
   
   // addShirtToSystem(nombre, descripcion, precio, image);
   // drawCardShirt();
}// save shirt

// aseguramos que se ejecute el js despues haber cargado todos los recursos
//externos
window.onload = ()=>{
   console.log("cargo")
   // document.getElementById("formulario").addEventListener("submit", saveShirt);
   let form =  document.getElementById("añadir")
   form.addEventListener("submit", saveShirt);

   // form.addEventListener("submit", function(){

   // })


}//windows