import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Alert, Button, StyleSheet, Text, TextInput, View } from 'react-native';

export default function App() {
  const [peso, setPeso] = useState("");
  const [altura, setaltura] = useState("");
  const [IMS, setIMS] = useState("");
  const [estado, setEstado] = useState("");

  const calcularIMS = () => {
    let p = parseFloat(peso);
    let a = parseFloat(altura)
    let alt=a/100
    let imsResult = p / (alt * alt);
    let imsResultFixed=imsResult.toFixed(1)
    setIMS(imsResultFixed);
    if (imsResultFixed < 18.5) {
      setEstado("peso bajo")
    } else if (imsResultFixed >= 18.5 && imsResultFixed <= 24.9) {
      setEstado("peso normal")
    } else if (imsResultFixed >= 25 && imsResultFixed <= 29.9) {
      setEstado("peso alto")
      Alert.alert("Peso Alto","A entrenar!")
    } else if (imsResultFixed >= 30) {
      setEstado("sobrepeso")
      Alert.alert("Sobrepeso","A entrenar mucho!")
    }
  }

  return (
    <View style={styles.container}>
      <View style={styles.box1}>
        <Text>                IMC - RANGO
          {'\n'} menor a 18.5 - peso bajo
          {'\n'}     18.5 a 24.9 - peso normal
          {'\n'}     25.0 a 29.9 - peso alto
          {'\n'}  mayor a 30.0 - sobrepeso
          {'\n'}
          {'\n'}
          {'\n'}             IMC: {IMS}
          {'\n'}             ESTADO: {estado}
          {'\n'}
          {'\n'}

        </Text>
        <StatusBar style="auto" />
      </View>
      <View style={styles.box2}>
        <Text>  Calculadora IMS! </Text>
        <Text></Text>
        <Text>  Altura: </Text>
        <TextInput
          style={styles.cajaText}
          value={altura}
          onChangeText={(txt) => { setaltura(txt)}}
          placeholder='Ingrese su altura en cm'
        />
        <Text></Text>
        <Text>  Peso: </Text>
        <TextInput
          style={styles.cajaText}
          value={peso}
          onChangeText={(txt) => { setPeso(txt)}}
          placeholder='Ingrese su peso en kg'
        />
        <Text></Text>
        <Button
          title='CALCULAR'
          onPress={calcularIMS}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    justifyContent: 'center',
  }, box1: {
    flex: 1,
    backgroundColor: 'white',
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'flex-end',
    padding: 5
  }, box2: {
    flex: 1,
    backgroundColor: 'white',
    flexDirection: 'column',
    alignItems: 'center',
    paddingTop: 20
  }, cajaText: {
    borderWidth: 2,
    borderColor: 'gray',
    marginTop: 5,
  }
});