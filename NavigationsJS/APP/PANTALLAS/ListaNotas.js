import { View, StyleSheet, FlatList, TouchableHighlight } from "react-native";
//ReactNative Elements
import { FAB, Avatar, ListItem } from "@rneui/base";
//Import Servicio
import{Lista} from '../SERVICIOS/ServicioArreglo'
//React
import { useState } from "react";

//EXPORT PRINCIPAL
export const VistaLista = ({ navigation }) => {
    //Atributo
    const[refesh,setRefresh]=useState(new Date().getTime());
    //Componente
    const ListaNotas = ({ nota }) => {
        return <TouchableHighlight
            onPress={() => { navigation.navigate('FORMULARIO NOTAS', { data : nota }); setRefresh(new Date().getTime()) }}>
            <ListItem bottomDivider>
                <Avatar
                    title={nota.materia.substring(0, 1)}
                    containerStyle={{ backgroundColor: 'black' }}
                    rounded
                />
                <ListItem.Content>
                    <ListItem.Title>{nota.materia}</ListItem.Title>
                </ListItem.Content>
                <ListItem.Content>
                    <ListItem.Title>{nota.calificacion}</ListItem.Title>
                </ListItem.Content>
            </ListItem>
        </TouchableHighlight>
    }
    //Fin del Componente
    return (
        <View style={styles.container}>
            <FlatList
                data={Lista()}
                renderItem={({ item }) => { return <ListaNotas nota={item} /> }}
                keyExtractor={(item) => { return item.materia }}
                extraData={refesh}
            />
            <FAB
                title='Agregar Nota +'
                placement="right"
                titleStyle={{ fontWeight: 800, fontSize: 15 }}
                buttonStyle={{
                    backgroundColor: 'green',
                    borderRadius: 150,
                    borderColor: 'transparent',
                }}
                onPress={() => { navigation.navigate('FORMULARIO NOTAS', { data: null }) }}
            />
            <FAB
                title='Reload'
                placement="left"
                icon={{
                    name: 'undo',
                    type: 'font-awesome',
                    color: 'white'
                }}
                titleStyle={{ fontWeight: 800, fontSize: 15 }}
                buttonStyle={{
                    backgroundColor: 'blue',
                    borderRadius: 150,
                    borderColor: 'transparent',
                }}
                onPress={() => { setRefresh(new Date().getTime()) }}
            />
        </View>
    )
}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',

    },
});