import { View, Text, StyleSheet, Button } from "react-native";

export const ScreenContactos = ({navigation}) => {
    return (<View style={styles.container}>
        <Text> Vista Contactos </Text>
        <Text></Text>
        <Button
            title='HOME'
            onPress={() => {
                navigation.navigate('HOME')
            }}
        />
    </View>)
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        justifyContent: 'center',
        alignItems: 'center'
    },
})