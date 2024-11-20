import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { StyleSheet, Text, View, FlatList, TextInput, Button, Alert, ScrollView } from 'react-native';
let productos = [
  { nombre: 'Doritos.', categoria: 'Snacks', precioVenta: 0.40 },
  { nombre: 'Rufles.', categoria: 'Snacks', precioVenta: 0.25 },
  { nombre: 'Chips.', categoria: 'Dulces', precioVenta: 0.20 },
  { nombre: 'Candy.', categoria: 'Dulces', precioVenta: 0.50 },
  { nombre: 'Gatorade.', categoria: 'Energizante', precioVenta: 1.00 },

]

let Nuevo = true;

export default function App() {
  let ComponentProducto = (prop) => {
    return (
      <View style={styles.elementoBOX}>
        <View style={styles.elemento}>
          <Text style={styles.elementLetter}>{prop.producto.nombre}  ({prop.producto.categoria}) </Text>
          <Text style={styles.price}>{prop.producto.precioVenta} $ </Text>

        </View>
        <View style={styles.componentebotton}>
          <Button
            title='E'
            color='green'
            onPress={() => {
              Nuevo = false;
              setNombre(prop.producto.nombre);
              setCategoria(prop.producto.categoria);
            }}
          />
          <Button
            title='x'
            color='red'
            onPress={() => {
              let indiceSeleccionado = prop.IND
              productos.splice(indiceSeleccionado, 1);
              setItems(productos.length);
            }}
          />
        </View>
      </View>
    );
  }
  const [nombre, setNombre] = useState("");
  const [categoria, setCategoria] = useState("");
  const [precio, setPrecio] = useState("");
  const [items, setItems] = useState(productos.length);

  const ProductoExistente = () => {
    let existe = false;
    for (let a = 0; a < productos.length; a++) {
      if (nombre.includes(productos[a].nombre)) {
        existe = true;
        break;
      }
    }
    return existe;
  }

  let NewProducto = () => {
    clean();
    Nuevo = true;
    clean();
  }

  const guardarProducto = () => {
    if (Nuevo == true) {
      if (ProductoExistente() == true) {
        Alert.alert("ALERTA", "PRODUCTO YA EXISTENTE")
      } else {
        let product = { nombre: nombre, categoria: categoria, precioVenta: parseFloat(precio) }
        productos.push(product);
        clean();
        Nuevo = true;
      }
    } else {
      Nuevo = false;
      for (let a = 0; a < productos.length; a++) {
        let p = {}
        p = productos[a]
        if (nombre == p.nombre && categoria == p.categoria) {
          p.precioVenta = precio;

          break;
        }
      }
      clean();
      Nuevo = true;

    }
  }

  let clean = () => {
    setNombre(null);
    setCategoria(null);
    setPrecio(null);
  };


  return (

    <View style={styles.container}>
      <View style={styles.containerCabeza}>
        <Text style={styles.lettertitle}> PROYECTO</Text>
        <Text style={styles.Project}>  Lista</Text>

      </View>
      <View style={styles.containerCuerpo}>
        <ScrollView>
          <View style={styles.container1}>
            <View style={styles.container1title}>
              <Text style={styles.title1}>  Ingresar nuevo producto</Text>
            </View>
            <View style={styles.container1box}>
              <View style={styles.container1boxV1}>
                <Text style={styles.title1}>  nombre:</Text>
                <TextInput
                  style={styles.cajaTextInput}
                  value={nombre}
                  onChangeText={(t) => {
                    setNombre(t);
                  }}
                  editable={Nuevo}
                ></TextInput>
                <Text style={styles.title1}>  categoria:</Text>
                <TextInput
                  style={styles.cajaTextInput}
                  value={categoria}
                  onChangeText={(t) => {
                    setCategoria(t);
                  }}
                  editable={Nuevo}
                ></TextInput>
              </View>
              <View style={styles.container1boxV2}>
                <Text style={styles.title1}>  precio $:</Text>
                <TextInput
                  style={styles.cajaTextInputv2}
                  value={precio}
                  onChangeText={(t) => {
                    setPrecio(t);
                  }}
                  keyboardType='numeric'
                ></TextInput>
                <Button
                  title='GUARDAR'
                  onPress={guardarProducto}
                ></Button>
                <Button
                  title='Refrescar'
                  color='skyblue'
                  onPress={NewProducto}
                ></Button>
              </View>
            </View>
            <View style={styles.container1titleb}>

            </View>
          </View>
        </ScrollView>
        <View style={styles.container2}>

          <View style={styles.box}>
            <Text style={styles.title}>Lista Productos: </Text>
            <Text>{items}</Text>

          </View>

          <FlatList
            data={productos}
            renderItem={(p) => {
              return <ComponentProducto IND={p.index} producto={p.item} />
            }}
            keyExtractor={(p) => {
              return p.nombre
            }}
          ></FlatList>

          <StatusBar style="auto" />
        </View>
      </View>
      <View style={styles.containerPie}>
        <Text style={styles.letterpie}>  by Danilo Isaac</Text>
      </View>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  }, containerCabeza: {
    flex: 2,
    backgroundColor: 'green',
    justifyContent: 'flex-start',
    alignItems: 'center',
    paddingTop: 35
  }, containerPie: {
    flex: 1,
    backgroundColor: 'black',
    paddingTop: 6,
    paddingRight: 10,
    flexDirection: 'row',
    alignContent: 'flex-end',
    justifyContent: 'flex-end'
  }, containerCuerpo: {
    flex: 15

  }, container1: {
    flex: 4,
    backgroundColor: 'white',
    flexDirection: 'column',
    justifyContent: 'flex-start',
    alignItems: 'center'

  }, container1title: {
    flex: 1

  }, container1titleb: {
    flex: 2,
    justifyContent: 'flex-end'
  }, container1box: {
    flex: 4,
    flexDirection: 'row'

  }, container1boxV1: {
    flex: 1

  }, container1boxV2: {
    flex: 1

  }, letterpie: {
    color: 'white'
  }, lettertitle: {
    color: 'white',
    fontSize: 25
  }, Project: {
    color: 'white',
    fontSize: 16
  }, title: {
    fontSize: 20,
  }, title1: {
    fontSize: 16,
  }, price: {
    fontStyle: 'italic',
    color: 'green'
  }, elementLetter: {
    fontSize: 15,
    marginBottom: 3
  }, box: {
    justifyContent: 'center',
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 5
  }, container2: {
    flex: 6,
    backgroundColor: '#fff',
    alignItems: 'streech',
    justifyContent: 'center',
    paddingTop: 60,
    padding: 40
  }, cajaTextInput: {
    borderColor: "black",
    color: "gray",
    borderWidth: 2,
    paddingVertical: 6,
    paddingHorizontal: 6
  }, cajaTextInputv2: {
    borderColor: "black",
    color: "gray",
    borderWidth: 2,
    paddingVertical: 6,
    paddingHorizontal: 6,
    marginBottom: 23.5
  }, componentebotton: {
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginBottom: 5,
  }, elementoBOX: {
    flexDirection: 'row',
  }, elemento: {
    borderColor: 'black',
    borderWidth: 2,
    paddingLeft: 15,
    marginBottom: 5,
    flex: 4.5,
  }
});