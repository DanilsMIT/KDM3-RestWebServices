import { StatusBar } from 'expo-status-bar';
import { Alert, StyleSheet, Text, View } from 'react-native';
import { Button, Icon,Input } from '@rneui/base';
import { useState } from 'react';
//Boton importado de React Native Elements

export default function App() {
  const[name,setName]=useState()

  return (
    <View style={styles.container}>
      <Text>React Native Elements!</Text>
      <Input
      value={name}
      onChangeText={setName}
      placeholder='Digite su nombre'
      />
      <Button
        title="HOME"
        icon={{
          name: 'home',
          type: 'font-awesome-5',
          color: 'yellow',
        }}
      />
      <Button
        title="Mostrar"
        icon={<Icon
          name='address-card'
          type='font-awesome-5'
          color='yellow'
      />}
      onPress={()=>{
        Alert.alert("INFO","Nombre Registrado: "+name)
      }}
      />
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
