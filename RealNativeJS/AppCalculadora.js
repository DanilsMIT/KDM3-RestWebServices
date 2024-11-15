import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';

export default function App() {

  const [n1, setN1] = useState("");
  const [n2, setN2] = useState("");
  const [result, setResult] = useState("");

  const SUMA = () => {
    let resultado = parseFloat(n1) + parseFloat(n2);
    setResult(resultado);
  }
  const RESTA = () => {
    let resultado = parseFloat(n1) - parseFloat(n2);
    setResult(resultado);

  }
  const PRODUCTO = () => {
    let resultado = parseFloat(n1) * parseFloat(n2);
    setResult(resultado);
  }

  return (
    <View style={styles.container}>
      <Text>Resultado: {result}</Text>
      <Text></Text>
      <Text>Calculadora!</Text>
      <Text></Text>
      <Text>Ingrese el numero 1:</Text>
      <TextInput
        style={styles.cajaText}
        value={n1}
        onChangeText={(n) => {
          setN1(n)
        }}
      />
      <Text></Text>
      <Text>Ingrese el numero 2:</Text>
      <TextInput
        style={styles.cajaText}
        value={n2}
        onChangeText={(n) => {
          setN2(n)
        }}
      />
      <Text></Text>
      <Button title='SUMAR' onPress={SUMA} />
      <Button title='RESTA' onPress={RESTA} />
      <Button title='PRODUCTO' onPress={PRODUCTO} />


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
  cajaText: {
    borderColor: 'black',
    borderWidth: 2,
    paddingVertical: 2,
    paddingHorizontal: 12,
    marginTop: 10
  }
});
