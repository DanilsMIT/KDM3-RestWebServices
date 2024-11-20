import React from 'react';
import { View, Text, TouchableHighlight, StyleSheet } from 'react-native';

const App = () => {
  const handlePress = () => {
    alert('TouchableHighlight Pressed!');
  };

  return (
    <View style={styles.container}>
      <TouchableHighlight 
        style={styles.button} 
        onPress={handlePress} 
        underlayColor="#DDDDDD" // Color when the button is pressed
      >
        <Text style={styles.buttonText}>Press Me</Text>
      </TouchableHighlight>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  button: {
    backgroundColor: '#2196F3', // Button color
    padding: 10,
    borderRadius: 5,
  },
  buttonText: {
    color: 'white',
    fontSize: 16,
  },
});

export default App;
