//ReactNative
import { View, StyleSheet, Alert } from "react-native";
//ReactNative Elements
import { Button, Input, FAB } from "@rneui/base";
//React
import { useState } from "react";

//Import Servicio
import { guardar, actualizar } from '../SERVICIOS/ServicioArreglo'

//EXPORT PRINCIPAL
let New = true;
export const VistaFormulario = ({ navigation, route }) => {
    //valores
    let Asignature = '';
    //comprobación de route
    if (route.params.data != null) { New = false; } else { New = true }
    //Seteo del valores
    if (New == false) {
        Asignature = route.params.data.materia
    }

    //Atributos objeto manejado
    const [materia, setMateria] = useState(Asignature);
    const [puntuacion, setPuntuacion] = useState();
    //ErroresAtributos
    const [errorMateria, setErrorMateria] = useState();
    const [errorPuntuacion, setErrorPuntuacion] = useState();

    //FUNCIONES
    const save = () => {
        let v = validacionAtributos();
        let PrimaryKey = LimpiarNombre(materia);
        if (v == true && New == true) {
            guardar({ materia: PrimaryKey, calificacion: parseFloat(puntuacion) });
            clean();
        };
        if (New == false) {
            actualizar({ materia: materia, calificacion: parseFloat(puntuacion) });
            New =true;
        };
    }
    const validacionAtributos = () => {
        let Verificacion = false;
        let materiaVerificada = true;
        let notaVerificada = true;

        if (materia == '' || materia==null) {
            setErrorMateria("Debe ingresar una asignatura")
            materiaVerificada = false;
        } else { setErrorMateria(null); materiaVerificada = true; }

        if (puntuacion < 0 || puntuacion > 10 || puntuacion == null) {
            setErrorPuntuacion("Debe ingresar una calificación entre 0 a 10 puntos")
            notaVerificada = false;
        } else { setErrorPuntuacion(null); notaVerificada = true; }

        if (materiaVerificada == true && notaVerificada == true) {
            Verificacion = true;
        } else { Verificacion = false; }

        return Verificacion;
    }
    const LimpiarNombre = (nombre) => {
        let nombrePurgado = nombre.trim().replace(/\./g, '');
        return nombrePurgado;
    }

    const clean=()=>{setMateria(null),setPuntuacion(null)}
    //FIN DE FUNCIONES

    //Return principal del EXPORT
    return (
        <View style={styles.container}>
            <Input
                value={materia}
                onChangeText={setMateria}
                label='Asignatura:'
                placeholder="Ejemplo: Informática..."
                errorMessage={errorMateria}
                disabled={New == false}
            />
            <Input
                value={puntuacion}
                onChangeText={setPuntuacion}
                label='Calificación:'
                placeholder="Ejemplo: 8.40..."
                keyboardType='numeric'
                errorMessage={errorPuntuacion}
            />
            <Button
                title='SAVE'
                icon={{
                    name: 'save',
                    type: 'font-awesome',
                    color: 'white'
                }}
                titleStyle={{
                    fontWeight: 800
                }}
                buttonStyle={{
                    borderRadius: 11,
                    borderColor: 'transparent',
                }}
                onPress={save}
            />
            <FAB
                title='Ver lista de notas'
                placement="center"
                titleStyle={{ fontWeight: 800, fontSize: 15 }}
                buttonStyle={{
                    backgroundColor: 'darkblue',
                    borderColor: 'transparent',
                    borderRadius: 150,
                }}
                onPress={() => { navigation.navigate('LISTA NOTAS') }}
            />
        </View>
    )
}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
});