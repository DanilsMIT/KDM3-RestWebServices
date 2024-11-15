import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, Button, Alert } from 'react-native';

export default function App() {
  const fin=()=>{
    Alert.alert("Sesion","SU SESION HA FINALIZADO");  
  };

  return (
    <View style={styles.container}>
      <Text>Bienvenido aprendiz de React Native, Danilo Isaac!</Text>
      <StatusBar style="auto" />
      <Button
        title='INICIAR'
        //Conocer las funciones que deben recibir las funciones de react native
        // Este es un caso de funcion que recibe una funcion como parametro.
        //OnPress recibe una funcion sin parametros.
        onPress={() => { Alert.alert("Sesion","SU SESION HA INICIADO")}}
      />
      <Button
      title='FINALIZAR'
      onPress={fin}/>
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
