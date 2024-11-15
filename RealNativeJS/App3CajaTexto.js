import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';

export default function App() {
  //Variable estado
  const [valor,setValor]=useState("Nombre");
  const [valor2,setValor2]=useState("Apellido");
  const [ValorCompleto, setValorCompleto]=useState("");
  return (
    <View style={styles.container}>
      <Text>Text Input!</Text>
      <Text>Saludos: {ValorCompleto} </Text>
      <TextInput 
      style={styles.cajaTextInput}
      value={valor}
      /*onChangeText se activa cada que se ingresa 
      a la caja de texto, funcion que recibe
      una funcion con parametro*/
      onChangeText={(txt)=>{
        setValor(txt);
      }}
      />
      <TextInput
      style={styles.cajaTextInput}
      value={valor2}
      onChangeText={(txt)=>{
        setValor2(txt);
      }}
      />
      <Button
        title='SALUDAR'
        onPress={()=>{
          let saludo=valor+" "+valor2
          setValorCompleto(saludo)
        }}      
      />
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
  cajaTextInput:{
    borderColor:"black",
    color:"gray",
    borderWidth: 2,
    paddingVertical:6,
    paddingHorizontal: 6
  }
});
