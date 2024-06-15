# -*- coding: utf-8 -*-

import cv2
from pyzbar.pyzbar import decode
import socket
import numpy as np

# Crear un socket para el servidor
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_host = '127.0.0.2'
server_port = 54321
server_socket.connect((server_host, server_port))

# Contraseña para la conexión
password = "Zamo2106"

# Inicializar la cámara
cap = cv2.VideoCapture(0)

barcode_sent = False  # Variable para controlar si se ha enviado el código de barras

while not barcode_sent:
    # Capturar el video cuadro a cuadro
    ret, frame = cap.read()

    # Decodificar códigos de barras en el cuadro capturado
    decoded_objects = decode(frame)

    # Mostrar los códigos de barras detectados
    for obj in decoded_objects:
        barcode_data = obj.data.decode('utf-8')
        print('Barcode Data:', barcode_data)

        if not barcode_sent:
            # Enviar el valor del código de barras y la contraseña al servidor Java
            data_to_send = f"{password}:{barcode_data}"
            server_socket.send(data_to_send.encode())
            barcode_sent = True  # Marcar que se ha enviado el código de barras

        # Dibujar un rectángulo alrededor del código de barras
        points = obj.polygon
        if len(points) > 4:
            hull = cv2.convexHull(np.array([point for point in points], dtype=np.int32))
            cv2.polylines(frame, [hull], True, (0, 255, 0), 2)

        # Mostrar el texto del código de barras en la transmisión en vivo
        cv2.putText(frame, f'Barcode: {barcode_data}', (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 255), 2)

    # Mostrar el cuadro capturado en una ventana
    cv2.imshow('Barcode Scanner', frame)
    cv2.waitKey(1)

# Cerrar la cámara y la conexión del cliente después de enviar el valor
cap.release()
server_socket.close()
cv2.destroyAllWindows()
