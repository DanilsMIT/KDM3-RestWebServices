misArmas=()=>{
    let armas=["Lanza","Estoque","Espadon"];
    armas.push("Alabarda");
    return armas;
}

testmisArmas=()=>{
    let armas=misArmas();
    let armaMaestro=armas[0];
    let armaExperto=armas[1];

    console.log(armaMaestro+", "+armaExperto);
}

testmisArmasDes=()=>{
    let[armaMaestro,armaExperto,armaProfesional]=misArmas();
    console.log(armaMaestro+", "+armaExperto+", "+armaProfesional);

}