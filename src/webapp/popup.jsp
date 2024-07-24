<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Popup</title>
    <style>
        .popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            background: white;
            border: 1px solid #ccc;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            z-index: 1000;
        }
        .popup.success {
            border-color: green;
        }
        .popup.error {
            border-color: red;
        }
        .popup button {
            margin-top: 10px;
            padding: 5px 10px;
            border: none;
            background-color: #007BFF;
            color: white;
            cursor: pointer;
        }
        .popup button.close {
            background-color: #dc3545;
        }
        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0,0,0,0.5);
            z-index: 999;
        }
    </style>
</head>
<body>
<div id="popupOverlay" class="overlay"></div>
<div id="popup" class="popup ${param.type}">
    <div id="popupMessage">${param.message}</div>
    <button id="popupButton" class="close">Fechar</button>
</div>

<script>
    window.onload = function() {
        var popup = document.getElementById('popup');
        var overlay = document.getElementById('popupOverlay');
        var popupButton = document.getElementById('popupButton');

        overlay.style.display = 'block';
        popup.style.display = 'block';

        popupButton.onclick = function() {
            popup.style.display = 'none';
            overlay.style.display = 'none';
            if ('${param.redirect}') {
                window.location.href = '${param.redirect}';
            }
        };
    };
</script>
</body>
</html>
