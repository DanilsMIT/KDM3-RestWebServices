import { StatusBar } from 'expo-status-bar';
import { Alert, Button, StyleSheet, Text, View } from 'react-native';
import { useState } from 'react';

export default function App() {

  let [contador, setContador] = useState(0);

  const incremento = () => {
    setContador(contador + 3);
  }
  const decremento = () => {
    if (contador <= 0) { 
      Alert.alert("GAMEOVER","Te has quedado sin vidas...");
    } else {
      setContador(contador - 1);
    };

  }

  return (
    <View style={styles.container}>
      <Text>Variables Estado!</Text>
      <Text>Vidas: {contador} </Text>
      <Button title='PREMIAR' onPress={incremento} />
      <Button title='PERDER VIDA' onPress={decremento} />
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
