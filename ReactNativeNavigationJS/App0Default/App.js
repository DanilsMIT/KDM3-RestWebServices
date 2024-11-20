import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import { Main } from './App/vistas/MainScreen';
import { ScreenContactos } from './App/vistas/ContactosScreen';
import { ScreenProductos } from './App/vistas/ProductosScreen';

const pantallita = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <pantallita.Navigator>

        <pantallita.Screen name='HOME' component={Main} />
        <pantallita.Screen name='CONTACTOS' component={ScreenContactos} />
        <pantallita.Screen name='PRODUCTOS' component={ScreenProductos} />

      </pantallita.Navigator>
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
