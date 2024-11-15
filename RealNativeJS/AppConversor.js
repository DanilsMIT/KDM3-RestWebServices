import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';

export default function App() {

  const [n, setN1] = useState("");
  const [result, setResult] = useState("");
  const [resultSigno, setResultSigno] = useState("");


  const PESOSMX = () => {
    let resultado = parseFloat(n) * 20.34;
    setResult(resultado);
    setResultSigno("Pesos MX");
  }
  const PESOSCO = () => {
    let resultado = parseFloat(n) * 4498.58;
    setResult(resultado);
    setResultSigno("Pesos CO");

  }
  const EUROS = () => {
    let resultado = parseFloat(n) * 0.95;
    setResult(resultado);
    setResultSigno("EUROS");

  }

  return (
    <View style={styles.container}>
      <Text>Conversion: {result} {resultSigno}</Text>
      <Text></Text>
      <Text>Convetidor de Moneda en Dolares!</Text>
      <Text></Text>
      <Text>Ingrese el monto a convertir:</Text>
      <TextInput
        style={styles.cajaText}
        value={n}
        onChangeText={(n) => {
          setN1(n)
        }}
      />
      <Text></Text>
      <Text></Text>
      <Button title='PESOS MX' onPress={PESOSMX} />
      <Button title='PESOS CO' onPress={PESOSCO} />
      <Button title='EUROS' onPress={EUROS} />


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
