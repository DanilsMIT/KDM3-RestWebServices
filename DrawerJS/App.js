//Import de handler elements --- 1
import 'react-native-gesture-handler';
//Import de NAVIGATIONS
import { NavigationContainer } from '@react-navigation/native'
import { createDrawerNavigator } from '@react-navigation/drawer'//---------->
//Imports native
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
//Pantallas
import { VistaFormulario } from './APP/PANTALLAS/FormularioNotas'
import { VistaLista } from './APP/PANTALLAS/ListaNotas'
//Componentes de Navegacion
const Drawer = createDrawerNavigator();//Save de la variable Drawer Navigator <------

/*const DrawerNavigation = () => {
  return (
    <Drawer.Navigator>

      <Drawer.Screen name='DrawerNavegación' component={VistaFormulario} options={{ title: 'Formulario' }} />
      <Drawer.Screen name='DrawerNavegación2' component={VistaLista} options={{ title: 'Lista' }} />

    </Drawer.Navigator>
  );
}*/

export default function App() {
  return (
    <NavigationContainer>
      <Drawer.Navigator>

        <Drawer.Screen name='DrawerNavegación' component={VistaFormulario} options={{ title: 'Formulario' }} />
        <Drawer.Screen name='DrawerNavegación2' component={VistaLista} options={{ title: 'Lista' }} />

      </Drawer.Navigator>
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
