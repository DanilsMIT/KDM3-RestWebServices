import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.containerCabeza}>
        <Text style={styles.lettertitle}> PROYECTO</Text>
        <Text style={styles.Project}>  Flex direcions</Text>

      </View>
      <View style={styles.containerCuerpo}></View>
      <View style={styles.containerPie}>
        <Text style={styles.letterpie}>  by Danilo Isaac</Text>
      </View>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },containerCabeza:{
    flex:2,
    backgroundColor:'green',
    justifyContent:'flex-start',
    alignItems:'center',
    paddingTop:35
  },containerPie:{
    flex:1,
    backgroundColor:'black',
    paddingTop:6,
    paddingRight:10,
    flexDirection:'row',
    alignContent:'flex-end',
    justifyContent:'flex-end'
  },containerCuerpo:{
    flex:15,
    backgroundColor:'white'
  },letterpie:{
    color:'white'
  },lettertitle:{
    color:'white',
    fontSize:25
  },Project:{
    color:'white',
    fontSize:16
  }
});