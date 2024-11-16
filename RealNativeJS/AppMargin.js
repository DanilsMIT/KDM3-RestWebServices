import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { StyleSheet, Text, TextInput, View } from 'react-native';

export default function App() {
  const [name, setName] = useState();
  const [nickname, setNickname] = useState();


  return (
    <View style={styles.container}>
      <Text style={styles.title}
      >Margin Padding!</Text>
      <TextInput
        style={styles.containertext}
        value={name}
        onChangeText={setName}
        placeholder='Ingrese su nombre'
      />
      <TextInput
        style={styles.containertext}
        value={nickname}
        onChangeText={setNickname}
        placeholder='Ingrese su alias'
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
    alignItems: 'stretch',
    paddingHorizontal: 50
  }, containertext: {
    borderWidth: 2,
    borderColor: 'black',
    marginTop: 10
  }, title: {
    fontFamily: 'serif',
    fontSize: 15
  }
});