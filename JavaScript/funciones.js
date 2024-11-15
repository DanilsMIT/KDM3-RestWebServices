
Operando=(operador)=>{
    console.log(">>Hola soy Operando, la funcion que invoca funciones, e invoco la funcion que me pasaron como parametro o utilizo el nombre recibido para luego invocar una funcion")
    let n1=recuperarInt("valor1");
    let n2=recuperarInt("valor2");
    let resultado=operador(n1,n2);
    console.log("Despues de haber llamado a la funcion en el parametro se imprime el resultado: ");
    console.log("resultado: "+resultado);
}

Suma=(n1,n2)=>{
    console.log(">>Hola soy la funcion invocada: Suma y tomo 2 valores como parametro y retorno la suma");
    console.log("valor 1 suma: "+n1+", valor 2 suma: "+n2);

    let result = n1+n2;
    return result;
}

Resta=(n1,n2)=>{
    console.log(">>Hola soy la funcion invocada: Resta y tomo 2 valores como parametro y retorno la suma");
    console.log("valor 1 resta: "+n1+", valor 2 resta: "+n2);

    let resultado = n1-n2;
    return resultado;
}