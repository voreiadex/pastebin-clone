const API_BASE_URL = '/api/pastes';

async function createPaste() {
    const content = document.getElementById('content').value;
    if (!content) {
        alert('Please enter some text');
        return;
    }

    try {
        const response = await fetch(API_BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain',
            },
            body: content
        });

        if (!response.ok) throw new Error('Failed to create paste');

        const shortUrl = await response.text();
        const fullUrl = `${window.location.origin}${API_BASE_URL}/${shortUrl}`;

        document.getElementById('result').innerHTML = `
            <p>Paste created successfully! Share this URL:</p>
            <input type="text" value="${fullUrl}" readonly style="width:100%; padding:8px; margin-top:5px;">
        `;
    } catch (error) {
        document.getElementById('result').innerHTML = `Error: ${error.message}`;
    }
}

async function viewPaste() {
    const shortUrl = document.getElementById('pasteUrl').value;
    if (!shortUrl) {
        alert('Please enter a paste URL key');
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/${shortUrl}`);
        if (!response.ok) throw new Error('Paste not found');

        const content = await response.text();
        document.getElementById('pasteContent').value = content;
    } catch (error) {
        document.getElementById('pasteContent').value = `Error: ${error.message}`;
    }
}