import { View,Text,StyleSheet, Button } from "react-native"

export const Main=({navigation})=>{
    return(<View style={styles.container}>
      <View style={styles.contenedor1}>
        <Text> Pagina Principal </Text>
        <Text></Text>
        </View>
        <View style={styles.contenedor2}>
        <Button
        title='CONTACTOS'
        onPress={()=>{
          navigation.navigate('CONTACTOS')
        }}
        />
        <Text></Text>
        <Button
        title='PRODUCTOS'
        onPress={()=>{
          navigation.navigate('PRODUCTOS')
        }}
        />
        </View>
    </View>)
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      justifyContent: 'center',
      alignItems: 'center',
    },contenedor1:{
      flex:1,
      flexDirection:'column',
      justifyContent:'flex-end',
      alignItems:'center'
    },contenedor2:{
      flex:1,
      flexDirection:'row',
      justifyContent:'center',
      alignItems:'flex-start'
    },
  });