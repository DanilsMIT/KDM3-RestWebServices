import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
    
      <StatusBar style="auto" />
      <Button title='COMP 1' color="yellow"/>
      <Button title='COMP 2' color="blue"/>
      <Button title='COMP 3'color="gold"/>
      <Button title='COMP 4' color="black"/>


    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    flexDirection: 'column',
    justifyContent: 'center',//Eje Principal
    alignItems: 'center',//Eje secundario, contrario al principal
  },
});