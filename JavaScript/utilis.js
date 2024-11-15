recuperarTexto=(idValor)=>{
    let valor = document.getElementById(idValor);
    let Componente=valor.value;
    return Componente;

}
recuperarInt=(idValor)=>{
    let valor=recuperarTexto(idValor);
    let valorInt=parseInt(valor);
    return valorInt;
}

recuperarFloat=(idValor)=>{
    let valor=recuperarTexto(idValor);
    let valorFloat=parseFloat(valor);
    return valorFloat;
}