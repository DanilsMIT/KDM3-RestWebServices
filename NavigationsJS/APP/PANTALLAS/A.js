import { View,Text,StyleSheet } from 'react-native'

export const View2 = () => {
    return(<View style={styles.container}>
        <Text>Config</Text>
    </View>)
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
      justifyContent: 'center',
    },
  });
  