import { StatusBar } from 'expo-status-bar';
import { FlatList, StyleSheet, Text, View } from 'react-native';
let productos = [
  { id: 101, nombre: 'Doritos', categoria: 'Snacks', precioCompra: 0.35, precioVenta: 0.40 },
  { id: 102, nombre: 'Rufles', categoria: 'Snacks', precioCompra: 0.20, precioVenta: 0.25 },
  { id: 103, nombre: 'Chips', categoria: 'Dulces', precioCompra: 0.15, precioVenta: 0.20 },
  { id: 104, nombre: 'Candy', categoria: 'Dulces', precioCompra: 0.2, precioVenta: 0.5 },
  { id: 105, nombre: 'Gatorade', categoria: 'Energizante', precioCompra: 0.85, precioVenta: 1.00 },

]

export default function App() {
  return (
    <View style={styles.container2}>
      <View style={styles.box}>
      <Text style={styles.title}> Lista Productos</Text>
      </View>
      <FlatList
        data={productos}
        renderItem={(p) => {
          return (
            <View  style={styles.elemento}>
              <Text style={styles.elementLetter}>{p.item.nombre}  ({p.item.categoria}) </Text>
              <Text style={styles.price}>{p.item.precioVenta} $ </Text>
            </View>
          );
        }}
        keyExtractor={(p) => {
          return p.id
        }
        }
      ></FlatList>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container2: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'streech',
    justifyContent: 'center',
    paddingTop: 60,
    padding: 40
  },title:{
    fontSize:20,
  }, elemento:{
    borderColor:'black',
    borderWidth:2,
    paddingLeft:15,
    marginBottom:5
  },price:{
    fontStyle:'italic',
    color:'green'
  },elementLetter:{
    fontSize:15,
    marginBottom:3
  },box:{
    justifyContent:'center',
    flexDirection:'row',
    alignItems:'center',
    marginBottom:5
  }
});