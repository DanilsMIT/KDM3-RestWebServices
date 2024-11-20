import { View, Text, StyleSheet, Button } from "react-native";

export const ScreenProductos = ({ navigation }) => {
    return (<View style={styles.container}>
        <Button
            title='HOME'
            onPress={() => {
                navigation.navigate('HOME')
            }}
        />
        <Text></Text>
        <Text> Vista PRODUCTOS </Text>

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