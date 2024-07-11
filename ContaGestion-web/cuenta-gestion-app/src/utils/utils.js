function formatoTiempo(miliseconds) {
    const seconds = miliseconds / 1000;
    const hours = Math.floor(seconds / 3600);
    const minutes = Math.floor((seconds % 3600) / 60);

    return `${hours} horas ${minutes} minutos`;
}

export { formatoTiempo };