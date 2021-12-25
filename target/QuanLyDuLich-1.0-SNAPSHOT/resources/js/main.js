/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function addToCart(id, tendulich, gia) {
    event.preventDefault()
    
   
    fetch("/QuanLyDuLich/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "id": id,
            "name": tendulich,
            "price": gia,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        console.info(res);
        return res.json();
    }).then(function(data) {
        console.info(data);
        let d = document.getElementsByClassName("cartCounter");
        for (let i = 0; i < d.length; i++)
            d[i].innerText = data.totalQuantity
    }).catch(function(err) {
        console.error(err);
    })
}
function updateCart(id, obj) {
    event.preventDefault()
    
    fetch("/QuanLyDuLich/api/cart", {
        method: 'put',
        body: JSON.stringify({
            "id": id,
            "quantity": parseInt(obj.value)
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res) {
        return res.json();
    }).then(function(data) {
        let d = document.getElementsByClassName("cartCounter");
        for (let i = 0; i < d.length; i++)
            d[i].innerText = data.totalQuantity
        
        let a = document.getElementById("amountId")
        a.innerText = data.totalAmount
    }).catch(function(err) {
        console.error(err);
    })
}


function deleteCart(productId) {
    event.preventDefault()
    
    if (confirm("Bạn có chắc chắn muốn xóa không?") == true) {
        fetch("/QuanLyDuLich/api/cart/" + productId, {
            method: 'delete',
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            location.reload()
        })
    }
}