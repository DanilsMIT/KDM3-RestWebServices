import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

//Imports Navigation
import { NavigationContainer } from '@react-navigation/native';//--> Variable del contenido de Navegacion
import { createNativeStackNavigator } from '@react-navigation/native-stack'//--->
const vistas = createNativeStackNavigator();//<---Componente de navegacion la variable de navegacion -Stack-

//Import Pantallas
import { VistaFormulario } from './APP/PANTALLAS/FormularioNotas'
import { VistaLista } from './APP/PANTALLAS/ListaNotas'

export default function App() {
  //Vista Principal que contiene las pantallas de navegaciones
  return (
    //Contenedor Principal de Navegacion // Navegacion // Pantallas
    <NavigationContainer> 
      <vistas.Navigator>

        <vistas.Screen name='LISTA NOTAS' component={VistaLista} />
        <vistas.Screen name='FORMULARIO NOTAS' component={VistaFormulario} />

      </vistas.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
