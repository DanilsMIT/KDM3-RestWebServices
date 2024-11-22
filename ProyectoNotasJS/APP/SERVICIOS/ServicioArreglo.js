import { Alert } from "react-native";

let asignaturas = [
    { materia: 'Valores', calificacion: 10 }
];

export const guardar = (asignatura) => {
    let ListaRevisada = true;
    for (let a = 0; a < asignaturas.length; a++) {
        if (asignaturas[a].materia.includes(asignatura.materia)) {
            ListaRevisada = false;
            break;
        } else { ListaRevisada = true }
    }
    if (ListaRevisada == true) {
        Alert.alert("¡Éxito!", "Se agregó la asignatura: " + asignatura.materia)
        asignaturas.push(asignatura);
    } else { Alert.alert('Fallo...', 'La Asignatura ya fue agregada.') }
    console.log(asignaturas);
};

export const actualizar = (asignatura) => {
    let ListaRevisada = false;
    let indice;
    for (let a = 0; a < asignaturas.length; a++) {
        if (asignatura.materia == asignaturas[a].materia) {
            indice=a;
            ListaRevisada=true;
            console.log(a);
            break;
        }
    }
    console.log(asignaturas[indice])
    if(ListaRevisada=true){
        asignaturas[indice]=asignatura;
        Alert.alert('AVISO','¡Nota actualizada!')
    }
    console.log(asignaturas[indice])


};

export const Lista = () => {
    return asignaturas;
};