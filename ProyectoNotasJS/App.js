import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

//Imports Navigation
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack'
const vistas = createNativeStackNavigator();

//Import Pantallas
import { VistaFormulario } from './APP/PANTALLAS/FormularioNotas'
import { VistaLista } from './APP/PANTALLAS/ListaNotas'

export default function App() {
  return (
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
