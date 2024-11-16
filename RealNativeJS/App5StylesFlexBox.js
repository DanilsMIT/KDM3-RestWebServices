import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.container2}></View>
      <View style={styles.container3}>
        <View style={styles.container4}></View>
        <View style={styles.container5}>
        <View style={styles.container6}></View>
        <View style={styles.container7}>
          <Button title='COMP 1'></Button>
          <Button title='COMP 2'></Button>
          <Button title='COMP 3'></Button>

        </View>

        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'black',
    flexDirection: "column"
  },
  container2: {
    flex: 1,
    backgroundColor: 'yellow',
  },
  container3: {
    flex: 3,
    backgroundColor: 'red',
    flexDirection: "column"
  },
  container4: {
    flex: 1,
    backgroundColor: 'blue',

  }, container5: {
    flex: 1,
    backgroundColor: 'pink',
    flexDirection: "row"

  }, container6: {
    flex: 1,
    backgroundColor: 'lightblue',

  }, container7: {
    flex: 2,
    backgroundColor: 'white',
    flexDirection: "column",
    alignItems:'center',
    justifyContent:'space-around'
  }
});