import { View,Text,StyleSheet } from 'react-native'

export const View1 = () => {
    return (<View style={styles.container}>
        <Text>FIN DE SESION</Text>
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
