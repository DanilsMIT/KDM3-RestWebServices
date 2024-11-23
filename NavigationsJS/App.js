//Import de handler elements --- 1
import 'react-native-gesture-handler';
//Import de NAVIGATIONS
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'//--------->
import { createDrawerNavigator } from '@react-navigation/drawer'//---------->
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'//-------->
//Imports native
import { StyleSheet, Text, View } from 'react-native';
//Pantallas 
import { VistaFormulario } from './APP/PANTALLAS/FormularioNotas'
import { VistaLista } from './APP/PANTALLAS/ListaNotas'
import { View1 } from './APP/PANTALLAS/B'
import { View2 } from './APP/PANTALLAS/A'
import { Icon } from '@rneui/base';

//Componentes de Navegacion
const Drawer = createDrawerNavigator();//Save de la navegacion Drawer Navigator <------
const BottomTab = createBottomTabNavigator();//Save de la navegacion BottomTab Navigator<-------
const Stack = createNativeStackNavigator();//Save de la navegacion Stack Navigator<-----

//Navegacion Drawer
const DrawerNavigation = () => {
  return (
    <Drawer.Navigator>

      <Drawer.Screen name='PantallaStack' component={StackNavigation} options={{ title: 'Stack' }} />
      <Drawer.Screen name='PantallaBottom' component={BottomTabNavigation} options={{ title: 'BottomTab' }} />

    </Drawer.Navigator>
  );
}

//Navegacion BottomTab
const BottomTabNavigation = () => {
  return (
    <BottomTab.Navigator>

      <BottomTab.Screen
        name='Nav1'
        component={View1}
        options={{
          headerShown: false,
          tabBarLabel: 'END',
          tabBarIcon: () => { return <Icon name='power-off' type='font-awesome' color='black' size={25} /> }
        }} />
      <BottomTab.Screen name='Nav2' component={View2}
        options={{
          headerShown: false, tabBarLabel: 'Config',
          tabBarIcon: () => { return <Icon name='gear' type='font-awesome' color='black' size={25} /> }
        }} />

    </BottomTab.Navigator>
  )
}

//Navegacion Stack
const StackNavigation = () => {
  return (
    <Stack.Navigator>

      <Stack.Screen name='LISTA NOTAS' component={VistaLista} />
      <Stack.Screen name='FORMULARIO NOTAS' component={VistaFormulario} />

    </Stack.Navigator>
  )
}

//Primera Vista Principal
export default function App() {
  return (
    <NavigationContainer>
      <DrawerNavigation />
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
