import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.container1}>
        <Button title='X'></Button>
        <Button title='Y'></Button>
        <Button title='Z'></Button>
      </View>
      <View style={styles.container2}>
      <View style={styles.container2p1}>
      <View style={styles.containerph1}>
      <Button title='BOTON 1'></Button>
      <Button title='BOTON 2'></Button>
      </View>
      <View style={styles.containerph2}>
      <Button title='OPERACION 1'></Button>
      <Button title='OPERACION 2'></Button>
      <Button title='OPERACION 3'></Button>
      </View>
      </View>
      <View style={styles.container2p2}>
      <Button title='ACCION 1'></Button>
      <Button title='ACCION 2'></Button>

      </View>
      </View>
      <View style={styles.container3}>
      <Button title='BOTON FINAL'></Button>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'black',

  }, container1: {
    flex: 1,
    backgroundColor: 'blue',
    flexDirection:'row',
    justifyContent:'flex-end',
    alignItems:'center'

  }, container2: {
    flex: 6,
    backgroundColor: 'lightblue',

  }, container3: {
    flex: 1,
    backgroundColor: 'green',
    justifyContent:'center',
    alignItems:'flex-start'

  }, container2p1: {
    flex: 4,
    backgroundColor: 'yellow',
    flexDirection: 'row'

  }, container2p2: {
    flex: 1,
    backgroundColor: 'red',
    flexDirection:'row',
    justifyContent:'center',
    alignItems:'flex-end'

  }, containerph1: {
    flex: 1,
    backgroundColor: 'yellow',
    justifyContent:'space-around',
    alignItems:'center'
    
  }, containerph2: {
    flex: 1,
    backgroundColor: 'white',
    justifyContent:'center',
    alignItems:'flex-start'
  }
});