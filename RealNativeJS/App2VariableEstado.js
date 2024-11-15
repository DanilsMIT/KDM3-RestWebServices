import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View } from 'react-native';
import { useState } from 'react';

export default function App() {
  //useState es un arreglo con 2 posiciones
  //posicion 1 contiene el valor ingresado en este caso es el int 0
  //posicion 2 tiene el metodo para refrescar la pantalla
  // y mostrar un nuevo valor de la variableEstado asignnada
  const useStado=useState(0);
  const ContadorEstado=useStado[0];
  const setContadorEstado=useStado[1];

  //SIMPLIFICADO 
  let[contador,setContador]=useState(0);

  const incremento=()=>{
    setContador(contador+1);
  }
  const decremento=()=>{
    setContador(contador-1);
  }

  return (
    <View style={styles.container}>
      <Text>Variables Estado!</Text>
      <Text>Contador de clicks: {contador} </Text>
      <Button title='Aumento' onPress={incremento}/>
      <Button title='Decremento' onPress={decremento}/>
      <StatusBar style="auto" />
    </View>
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
